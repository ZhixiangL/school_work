(*
Zhixiang Li V00906200
*)
structure Babies =
struct
local
  open Csc330
in
  
fun babies_program (fileName, yearSt) =
  let 
    (* preparations *)
    val records_list = split_at (read_file fileName, #"\n");
    val r_count = 
      let
        fun record_count (r_list: string list) : int = 
          if null r_list
          then 0
          else 1+record_count (tl r_list)
      in record_count records_list
      end

    val splitted_records_list = 
      let
        fun records_split (str_list: string list) : (string*(int list)*int) list = 
          if null str_list
          then []
          else 
            let 
              val record_splitted = split_at (hd str_list, #",")
              fun entries rest_list : int list =
                if null (tl rest_list)
                then []
                else valOf (fromString(hd rest_list)) :: entries (tl rest_list)
              fun get_sum rest_list : int =
                if null (tl rest_list)
                then valOf (fromString (hd rest_list))
                else get_sum (tl rest_list)
            in
              (hd record_splitted, entries (tl record_splitted), get_sum (tl record_splitted))::records_split (tl str_list)
            end
      in records_split records_list
      end
    
    val e_count = 
      let
        fun entry_count(e_list: int list) : int = 
          if null e_list
          then 0
          else 1+entry_count(tl e_list)
      in entry_count(#2 (hd splitted_records_list))
      end

    (* get input *)
    val input_list = split_at(read_stdin (), #"\n");
    (* print basic info *)
    val _ = print ("Read "^int_to_string(r_count)^" babies"^dot^" Starting year "^yearSt^dot^" Each baby has "^int_to_string(e_count)^" entries"^dot^"\n")
    
    (* search for each input name, print out stats data *)
    fun inputs_search (i_list : string list) : string = 
      if null i_list
      then ""
      else 
        let
          fun one_name_search (name: string, records: (string*(int list)*int) list) : string = 
            let
              fun stats_output (record : string*(int list)*int) : string = 
                let
                  val years = 
                    let
                      fun years_cal (entries : int list): int = 
                        if null entries
                        then 0
                        else if hd entries = 0
                        then 0+years_cal (tl entries)
                        else 1+years_cal (tl entries)
                    in years_cal (#2 record)
                    end
                  
                  val (end_year, end_year_num) = 
                    let
                      fun end_year_cal (year: int, entries : int list) : int*int = 
                        if null (tl entries)
                        then (year, hd entries)
                        else end_year_cal (year+1, tl entries)
                    in end_year_cal (valOf (fromString (yearSt)), (#2 record))
                    end
                  
                  val (first_year, first_year_num) = 
                    let
                      fun first_cal (year: int, entries : int list) : int*int = 
                        if hd entries >0
                        then (year, hd entries)
                        else first_cal (year+1, tl entries)
                    in first_cal (valOf (fromString (yearSt)), (#2 record))
                    end

                  val (last_year, last_year_num) = 
                    let
                      fun last_cal (year: int, entries : int list) : int*int = 
                        let
                          fun zero_list (l : int list) : bool = 
                            if null l
                            then true
                            else if hd l <> 0
                            then false
                            else zero_list(tl l) 
                        in
                          if hd entries > 0 andalso zero_list(tl entries)
                          then (year, hd entries)
                          else last_cal (year+1, tl entries)
                        end
                    in last_cal (valOf (fromString (yearSt)), (#2 record))
                    end
                  
                  val (min_year, min_year_num) = 
                    let
                      fun min_cal (year : int, min_year : int, mi : int, entries : int list) : int*int = 
                        if null entries
                        then (min_year, mi)
                        else
                          let
                          in
                            if (mi = 0 andalso hd entries <> 0) orelse (hd entries < mi andalso hd entries <> 0)
                            then min_cal (year+1, year, hd entries, tl entries)
                            else min_cal (year+1, min_year, mi, tl entries)
                          end
                    in min_cal (valOf(fromString(yearSt)), valOf(fromString(yearSt)), 0, (#2 record))
                    end
                  
                  val (max_year, max_year_num) = 
                    let
                      fun max_cal (year : int, max_year : int, ma : int, entries : int list) : int*int = 
                        if null entries
                        then (max_year, ma)
                        else
                          let
                          in
                            if hd entries >= ma
                            then max_cal (year+1, year, hd entries, tl entries)
                            else max_cal (year+1, max_year, ma, tl entries)
                          end
                    in max_cal (valOf(fromString(yearSt)), valOf(fromString(yearSt)), 0, (#2 record))
                    end

                  val avg = int_to_real(#3 record) / int_to_real(e_count)
                  
          
                in 
                  " Total: " ^ int_to_string (#3 record) ^ "\n" ^
                  " Years: " ^ int_to_string (years) ^ "\n" ^
                  " " ^ int_to_string (end_year) ^ ": "^ int_to_string (end_year_num) ^ "\n" ^
                  " First: " ^ int_to_string (first_year) ^ " " ^ int_to_string (first_year_num) ^ "\n" ^
                  " Last: " ^ int_to_string (last_year) ^ " " ^ int_to_string (last_year_num) ^ "\n" ^
                  " Min: " ^ int_to_string (min_year) ^ " " ^ int_to_string (min_year_num) ^ "\n" ^
                  " Max: " ^ int_to_string (max_year) ^ " " ^ int_to_string (max_year_num) ^ "\n" ^
                  " Avg: " ^ real_to_string (avg) ^ "\n"
                end
            in
              if null records
              then name^"\nBaby name ["^name^"] was not found\n"
              else if name = #1 (hd records)
              then name^"\n"^stats_output(hd records)
              else one_name_search (name, tl records)
            end
        in
          one_name_search (hd i_list, splitted_records_list) ^ inputs_search (tl i_list)
        end
    
    val _ = print(inputs_search (input_list))
  in
    ()
  end
        

(*
do not modify below this point
*)
        
fun main (prog_name, args) =
    let
      val (_, fileName, offsetSt) = parse_command_line args
      val _ = babies_program(fileName, offsetSt)
    in
      exit()
    end

end

end
    
