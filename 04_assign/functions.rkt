#lang racket


(provide (all-defined-out)) ;; so we can put tests in a second file

; part 1
(define nat-num-stream
  (letrec
      ([f (lambda (x)
            (cons x (lambda () (f (+ x 1)))))])
    (lambda () (f 0))))

;#1
(define add-pointwise 
  (lambda (xs ys) 
    (if (and (list? xs) (list? ys))
      (if (null? xs)
          (if (null? ys)
              null
              ys)
          (if (null? ys)
              xs
              (cons (+ (car xs) (car ys)) (add-pointwise (cdr xs) (cdr ys)))))
      (error "illegal parameter"))))
    

;#2
(define add-pointwise-lists 
  (lambda (xs) 
    (if (null? (cdr xs))
        (car xs)
        (add-pointwise (car xs) (add-pointwise-lists (cdr xs))))))

;#3
(define add-pointwise-lists-2 
  #f)

;#4
(define stream-for-n-steps 
  (lambda (stream n)
    (if (> n 0)
      (cons (car (stream)) (stream-for-n-steps (cdr (stream)) (- n 1)))
      null)))

;#5
(define fibo-stream 
  (letrec
      ([f (lambda (x y)
            (if (= (+ x y) 0)
            (cons 0 (lambda () (f 1 0)))
            (cons (+ x y) (lambda () (f y (+ x y))))))])
      (lambda () (f 0 0))))

;#6
(define filter-stream 
  (letrec
      ([f (lambda (filter stream)
            (if (filter (car (stream)))
            (cons (car (stream)) (lambda () (f filter (cdr (stream)))))
            (f filter (cdr (stream))) ))])
      (lambda (x y) (lambda () (f x y)))))

;#7
(define palyndromic-numbers 
  (letrec 
      ([pal (lambda (n) 
          (let ([li (string->list (number->string n))])
          (equal? li (reverse li)))  )])
      (filter-stream pal nat-num-stream)))

;#8 macro create-stream
(define-syntax create-stream 
  (syntax-rules (using starting at with increment)
    [(create-stream name using fu starting at i0 with increment delta) 
     (define name 
        (letrec
          ( [func fu]
            [f (lambda (x)
                (cons (func x) (lambda () (f (+ x delta)))))])
        (lambda () (f i0)))   )]))
; part 2

;#1
(define vector-assoc #f)

;#2
(define cached-assoc #f)
