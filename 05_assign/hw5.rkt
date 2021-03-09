 #lang racket

(provide (all-defined-out)) ;; so we can put tests in a second file

;; definition of structures for MUPL programs - Do NOT change
(struct var  (string) #:transparent)  ;; a variable, e.g., (var "foo")
(struct int  (num)    #:transparent)  ;; a constant number, e.g., (int 17)
(struct add  (e1 e2)  #:transparent)  ;; add two expressions
(struct ifgreater (e1 e2 e3 e4)    #:transparent) ;; if e1 > e2 then e3 else e4
(struct fun  (nameopt formal body) #:transparent) ;; a recursive(?) 1-argument function
(struct call (funexp actual)       #:transparent) ;; function call
(struct mlet (var e body) #:transparent) ;; a local binding (let var = e in body)
(struct apair (e1 e2)     #:transparent) ;; make a new pair
(struct fst  (e)    #:transparent) ;; get first part of a pair
(struct snd  (e)    #:transparent) ;; get second part of a pair
(struct aunit ()    #:transparent) ;; unit value -- good for ending a list
(struct isaunit (e) #:transparent) ;; evaluate to 1 if e is unit else 0

;; a closure is not in "source" programs; it is what functions evaluate to
(struct closure (env fun) #:transparent)

;; Problem A

;; CHANGE (put your solutions here)
(define (mupllist->racketlist lst)
  (if (aunit? lst) 
      null
      (cons 
          (let ([head (apair-e1 lst)]) 
              (if (or (apair? head) (aunit? head)) (mupllist->racketlist head) head)) 
          (mupllist->racketlist (apair-e2 lst)))  ))
(define (racketlist->mupllist lst)
 (if (null? lst)
      (aunit)
      (apair 
          (let ([head (car lst)]) 
              (if (list? head) (racketlist->mupllist head) head)) 
          (racketlist->mupllist (cdr lst)))   ))

;; Problem B

;; lookup a variable in an environment
;; Do NOT change this function
(define (envlookup env str)
  (cond [(null? env) (error "unbound variable during evaluation" str)]
        [(equal? (car (car env)) str) (cdr (car env))]
        [#t (envlookup (cdr env) str)]))

;; Do NOT change the two cases given to you.
;; DO add more cases for other kinds of MUPL expressions.
;; We will test eval-under-env by calling it directly even though
;; "in real life" it would be a helper function of eval-exp (see below).
(define (eval-under-env e env)
  (cond [(var? e)
         (envlookup env (var-string e))]
        [(add? e)
         (let ([v1 (eval-under-env (add-e1 e) env)]
               [v2 (eval-under-env (add-e2 e) env)])
           (if (and (int? v1)
                    (int? v2))
               (int (+ (int-num v1)
                       (int-num v2)))
               (error "MUPL addition applied to non-number")))]
        [(int? e) e]
        [(aunit? e) e]
        [(ifgreater? e) 
         (let ([v1 (eval-under-env (ifgreater-e1 e) env)]
               [v2 (eval-under-env (ifgreater-e2 e) env)])
            (if (and (int? v1) (int? v2)) 
                (if (> (int-num v1) (int-num v2)) (eval-under-env (ifgreater-e3 e) env) (eval-under-env (ifgreater-e4 e) env))
                (error "MUPL ifgreater applied to non-number")  )  )]
        [(apair? e) 
          (let ([v1 (eval-under-env (apair-e1 e) env)]
               [v2 (eval-under-env (apair-e2 e) env)])
            (apair v1 v2) )]
        [(fst? e) 
          (let ([v1 (eval-under-env (fst-e e) env)])
            (if (apair? v1) 
                (apair-e1 v1)
                (error "MUPL fst applied to non-apair") ) )]
        [(snd? e) 
          (let ([v1 (eval-under-env (snd-e e) env)])
            (if (apair? v1) 
                (apair-e2 v1)
                (error "MUPL snd applied to non-apair") ) )]   
        [(isaunit? e) 
          (let ([v1 (eval-under-env (isaunit-e e) env)])
            (if (aunit? v1) (int 1) (int 0)) )]
        [(mlet? e) 
          (let ([v1 (eval-under-env (mlet-e e) env)])
            (eval-under-env (mlet-body e) (cons (cons (mlet-var e) v1) env))  )]
        [(fun? e)
          (closure env e)]
        [(call? e)
          (let ([v1 (eval-under-env (call-funexp e) env)]
               [v2 (eval-under-env (call-actual e) env)])
              (if (closure? v1)
                  (let* ([f (closure-fun v1)]
                        [fun-env (cons (fun-nameopt f) v1)]
                        [arg-env (cons (fun-formal f) v2)]
                        [total-env 
                            (if (fun-nameopt f)
                                (cons arg-env (cons fun-env (closure-env v1)))
                                (cons arg-env (closure-env v1))  )]) 
                      (eval-under-env (fun-body (closure-fun v1)) total-env  ))
                  (error "MUPL call applied to non-closure")   ))]
        [#t (error (format "bad MUPL expression: ~v" e))]))

;; Do NOT change
;; note how evaluating an expression start with an empty environment
(define (eval-exp e)
  (eval-under-env e null))

;; Problem C

(define (ifaunit e1 e2 e3)  (ifgreater (isaunit e1) (int 0) e2 e3))

(define (mlet* lstlst e2) 
  (if (null? lstlst)
      e2
      (mlet (car (car lstlst)) (cdr (car lstlst)) (mlet* (cdr lstlst) e2))))

(define (ifeq e1 e2 e3 e4) (ifgreater e1 e2 e4 (ifgreater e2 e1 e4 e3)))

;; Problem D

(define mupl-map 
  (fun "mupl-map" "f" 
      (fun #f "lst" 
          (ifaunit (var "lst") (aunit) 
              (apair  
                  (call (var "f") (fst (var "lst"))) 
                  (call (call (var "mupl-map") (var "f")) (snd (var "lst"))) )) )))
;; this binding is a bit tricky. it must return a function.
;; the first two lines should be something like this:
;;
;;   (fun "mupl-map" "f"    ;; it is  function "mupl-map" that takes a function f
;;       (fun #f "lst"      ;; and it returns an anonymous function
;;          ...
;;
;; also remember that we can only call functions with one parameter, but
;; because they are curried instead of
;;    (call funexp1 funexp2 exp3)
;; we do
;;    (call (call funexp1 funexp2) exp3)
;; 

(define mupl-mapAddN
  (mlet "map" mupl-map
    (fun "mupl-map" "i" 
      (fun #f "lst" 
          (call (call (var "map") (fun #f "x" (add (var "i") (var "x")))) (var "lst")) ))))
