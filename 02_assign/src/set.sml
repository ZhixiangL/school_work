(*
Your name: Zhixiang Li
Your student id: V00906200
*)

structure Set =
struct
local
  open Csc330
in

datatype 'a set = EmptySet of ('a * 'a -> order) | Set of 'a list * ('a * 'a -> order)

exception SetIsEmpty

infix 1 IDENTICAL
infix 3 EXCEPT
infix 4 IS_SUBSET_OF
infix 5 INTERSECT
infix 6 UNION
infix 7 IN
infix 8 CONTAINS        
infix 9 ++
infix 9 --

fun is_empty_set s =
    case s of
        EmptySet _ => true
      | Set ([], _) => true
      | _ => false 

fun min_in_set s =
    case s of
        EmptySet _ => raise SetIsEmpty
      | Set ([], _) => raise SetIsEmpty 
      | Set (y::ys, _) => y

fun max_in_set s =
    case s of
        EmptySet _ => raise SetIsEmpty
      | Set (xs, _) => 
            let
                fun get_last li =
                    case li of
                        [] => raise SetIsEmpty
                      | y::[] => y
                      | y::ys => get_last ys
            in get_last xs
            end  

fun insert_into_set(s,v) =
    case s of
        EmptySet comp => Set (v::[], comp)
      | Set ([], comp) => Set (v::[], comp)
      | Set (xs, comp) => 
            let
                fun reverse (xs) = 
                    let
                        fun aux(lst, acc) = case lst of [] =>Set(acc,comp) | head::tail => aux(tail, head::acc)
                    in
                        aux(xs, [])
                    end
                fun combine (lst1, lst2) = 
                    let
                        fun aux(lst, acc) = case lst of [] =>Set(acc, comp) | head::tail => aux(tail, head::acc)
                    in
                        aux(lst1, lst2)
                    end
                fun insert (part1, part2) =
                    case part2 of
                        [] => reverse(v::part1)
                      | y::ys => 
                            if comp (v, y) = LESS
                            then combine(part1,v::part2)
                            else if comp (v, y) =EQUAL
                            then s
                            else insert(y::part1,ys)
            in insert ([], xs)
            end  

fun in_set(s, v) =
    case s of
        EmptySet _ => false
      | Set (xs, comp) =>
            let
                fun in_test li =
                    case li of
                        [] => false
                      | y::ys => 
                            if comp(v,y) = EQUAL
                            then true
                            else if comp (v, y) = LESS
                            then false
                            else in_test ys
            in in_test xs
            end  

fun union_set(s, t) =
    case s of
        EmptySet _ => t
      | Set (xs, comp) =>
            let
                fun aux (xs, acc) = 
                    case xs of
                        [] => acc
                      | y::ys => aux (ys, insert_into_set(acc, y))
            in aux (xs, t)
            end

fun intersect_set(s, t) =
    case s of
        EmptySet _ => s
      | Set (xs, comp) =>
            let
                fun aux (xs, acc) = 
                    case xs of
                        [] => acc
                      | y::ys => 
                            if in_set(t, y) 
                            then aux (ys, insert_into_set(acc, y)) 
                            else aux (ys, acc)
                   
            in aux (xs, EmptySet comp)
            end

fun except_set(s, t) =
    case s of
        EmptySet _ => s
      | Set (xs, comp) =>
            let
                fun aux (xs, t, acc) = 
                    case xs of
                        [] => acc
                      | y::ys => 
                            if in_set(t, y) 
                            then aux (ys, t, acc) 
                            else aux (ys, t, insert_into_set(acc, y))
            in aux (xs, t, EmptySet comp)
            end


fun remove_from_set(s,v) =
    case s of
        EmptySet _ => s
      | Set (xs, comp) => 
            let
                fun remove li =
                    case li of
                        [] => []
                      | y::ys => 
                            if comp (v, y) = LESS
                            then li
                            else if comp (v, y) =EQUAL
                            then ys
                            else y::(remove ys)
            in Set (remove xs, comp)
            end 
    
fun size_set(s: 'a set) =
    case s of
        EmptySet _ => 0
      | Set (xs, _) => 
            let
                fun size_of li =
                    case li of
                        [] => 0
                      | y::ys => 1 + size_of ys
            in size_of xs
            end 

fun equal_set(s, t) =
    case except_set(s, t) of
        EmptySet _ => size_set(s) = size_set(t)
      | _ => false

fun is_subset_of(s, t) =
    case except_set(s, t) of
        EmptySet _ => true
      | _ => false
        
fun list_to_set(lst, f) =
    let
        fun insert_list (li, acc) = 
            case li of 
                [] => acc
              | x::xs => insert_list(xs, insert_into_set(acc, x))
    in insert_list (lst, EmptySet f)
    end

fun set_to_list s =
    case s of
        EmptySet _ => []
      | Set (xs, _) => xs

fun str_set (s, fstr) =
    case s of
        EmptySet _ => "{}"
      | Set (xs, _) => 
            let
                fun str_lst li =
                    case li of
                        [] => ""
                      | x::[] => fstr(x)
                      | x::xs => fstr(x)^":"^str_lst xs
            in "{"^str_lst xs^"}"
            end
      
fun map_set (s, fcomp, f) =
    case s of
        EmptySet _ => EmptySet fcomp 
      | Set (xs, _) => 
            let
                fun map_list (li, acc) =
                    case li of
                        [] => acc
                      | y::ys => map_list(ys, insert_into_set(acc, f y))
            in map_list (xs, EmptySet fcomp)
            end 

fun s -- v = remove_from_set(s,v)
fun s ++ v = insert_into_set(s, v)
fun s IDENTICAL t = equal_set (s, t)
fun s UNION t = union_set (s, t)
fun s INTERSECT t = intersect_set (s, t)
fun s EXCEPT t = except_set (s, t)
fun v IN s = in_set (s, v)
fun s CONTAINS v = in_set(s,v)
fun s IS_SUBSET_OF t = is_subset_of (s, t)


fun comp_list_any (a: 'a list, b: 'a list, fcomp : ('a * 'a) -> order) =
    let 
        fun list_compare (lst1, lst2) =
            case (lst1, lst2) of
                ([], []) => EQUAL
              | ([], _) => LESS
              |  (_, []) => GREATER
              | (x::xs, y::ys) => 
                    if fcomp(x,y)=EQUAL 
                    then list_compare(xs, ys) 
                    else fcomp(x,y)
    in
        list_compare(a, b)
    end
                          
end
end    
