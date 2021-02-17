(*
Your name: Zhixiang Li
Your student id: V00906200
*)

structure Patterns =

struct

exception NoAnswer
exception NotFound

datatype tree = emptyTree |
                nodeTree of int * tree * tree


datatype pattern = Wildcard
		 | Variable of string
		 | UnitP
		 | ConstP of int
		 | TupleP of pattern list
		 | ConstructorP of string * pattern

datatype value = Const of int
	       | Unit
	       | Tuple of value list
	       | Constructor of string * value


(* write your tree functions here *)

fun tree_insert_in_order (t, v) = 
    case t of 
        emptyTree => nodeTree(v, emptyTree, emptyTree)
      | nodeTree (va, left, right) => 
            if v <= va
            then nodeTree(va, tree_insert_in_order(left, v), right)
            else nodeTree(va, left, tree_insert_in_order(right, v))

fun tree_height t = 
    case t of 
        emptyTree => 0
      | nodeTree (va, left, right) => 
            let
                fun max (v1, v2) = if v1<=v2 then v2 else v1
            in
                max(tree_height(left), tree_height(right))+1
            end

fun tree_fold_pre_order f acc t =
    case t of 
        emptyTree => acc
      | nodeTree(va, left, right) => tree_fold_pre_order f (tree_fold_pre_order f (f(acc, va)) left) right

val tree_max = fn t =>
    case t of 
        emptyTree => NONE
      | nodeTree _ => SOME (tree_fold_pre_order (fn (acc, v)=> if acc<v then v else acc) 0 t)
    

fun tree_delete (t, v) = 
    case t of 
        emptyTree => raise NotFound
      | nodeTree (va, emptyTree, right) => right
      | nodeTree (va, left, emptyTree) => left
      | nodeTree (va, left, right) => 
          let
          in
              if v=va
              then 
                  let val left_max = case (tree_max left) of NONE => 0 | SOME x=>x
                  in nodeTree (left_max, tree_delete(left, left_max), right)
                  end
              else if v<va
              then nodeTree (va, tree_delete(left, v), right)
              else nodeTree (va, left, tree_delete(right, v))
          end



val tree_to_list = fn t => 
    let
        fun reverse (lst, acc) = 
            case lst of
                [] => acc
              | x::xs => reverse(xs,x::acc)
    in
        reverse((tree_fold_pre_order (fn (acc, v)=>v::acc) [] t),[])
    end

fun tree_filter f t =
    case t of 
        emptyTree => emptyTree
      | nodeTree (va, left, right) => 
          if f va = true
          then
            nodeTree(va, tree_filter f left, tree_filter f right)
          else
            tree_filter f (tree_delete(t, va))

val tree_sum_even = (tree_fold_pre_order (fn (acc, v)=>acc+v) 0) o (tree_filter (fn v=> (v mod 2) = 0))

fun first_answer f lst =
    case lst of
        [] => raise NoAnswer
      | x::xs => case f(x) of SOME v =>v | NONE => (first_answer f xs)

fun append (lst1, lst2) =
    let
        fun aux (xs,acc) =
            case xs of
                [] => acc
              | y::ys=> y::acc
    in
        aux(List.rev(lst1), lst2)
    end
    
fun all_answers f lst =
    case lst of
        [] => SOME []
      | x::[] => (case f(x) of SOME v => SOME v | NONE=>NONE)
      | x::xs => 
          case f(x) of 
              SOME v => (case (all_answers f xs) of NONE => NONE | SOME lst1 => SOME (append(v, lst1)))
            | NONE => NONE

fun check_pattern p =
    let
        fun add_list (lst1, lst2) = 
          let 
              fun aux (lst, acc) = case lst of [] => acc | x::xs => aux(xs, x::acc)
          in aux(lst1, lst2)
          end
        fun pattern_variables p =
            case p of 
                Variable s => s::[]
              | ConstructorP (_, pat) => pattern_variables pat
              | TupleP [] =>  []
              | TupleP lst => List.foldl (fn(x, acc)=>add_list(pattern_variables(x),acc)) [] lst
              | _ => []
        fun list_is_not_repeat lst =
            case lst of
                [] => true
              | x::xs => if (List.exists (fn(v)=> v=x) xs) then false else list_is_not_repeat(xs)
    in
        list_is_not_repeat(pattern_variables p)
    end

fun match (v, p) :(string * value) list option= 
    case (p, v) of
        (Variable s, v1) => (SOME ((s, v1)::[]))
      | (UnitP, Unit) => SOME []
      | (ConstP i, Const j) => if i=j then SOME [] else NONE
      | (TupleP ps, Tuple vs) => 
          if List.length(ps)=List.length(vs) then (all_answers match (ListPair.zip(vs, ps))) else NONE
      | (ConstructorP (s1, p1), Constructor(s2, v1)) => if s1=s2 then match(v1,p1) else NONE
      | (Wildcard, _) => SOME []
      | _ => NONE



fun first_match v pattern_list =
    case pattern_list of
        [] => NONE
      | ps => SOME (first_answer (fn pa => match(v,pa)) ps) handle NoAnswer => NONE
      (* case match(v,p) of NONE => (first_match v ps) | SOME x => SOME x *)
      
(* leave the following functions untouched *)

fun tree_root t =
    case t of
        emptyTree => NONE
      | nodeTree (n, _, _) => SOME n

fun tree_equal t1 t2  =
    case (t1, t2) of
        (emptyTree, emptyTree) => true
      | (emptyTree, _) =>  false
      | (_, emptyTree) => false
      | (nodeTree(n1, l1, r1),nodeTree(n2, l2, r2)) =>
        n1 = n2 andalso (tree_equal l1 l2) andalso (tree_equal r1 r2)

infix 9 ++
infix 9 --
infix 7 == 

fun t ++ v = tree_insert_in_order(t, v)
fun t -- v = tree_delete(t, v)
fun t1 == t2 = tree_equal t1 t2

end

