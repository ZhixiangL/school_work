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
      val _ = print ("Filename to read " ^ fileName ^ "\n")
      val _ = print ("First year  " ^ yearSt ^ "\n")
    in
      let 
        (* preparations *)
        val file_str = read_file fileName;
        val record_list = split_at(file_str, #"\n");
        fun record_count (r_list: string list) : int = 
          if null r_list
          then 0
          else 1+record_count(tl r_list)
        val r_count = record_count record_list;
        fun record_split(str_list: string list) : (string*(int list)*int) list = 
          if null str_list
          then []
          else 
            let 
              val record = hd str_list
              val record_splitted = split_at(record, #",")
              val name = hd record_splitted;
              fun entries rest_list : int list =
                if null (tl rest_list)
                then []
                else valOf(fromString(hd rest_list)) :: entries(tl rest_list)
              fun get_sum rest_list : int =
                if null (tl rest_list)
                then valOf(fromString(hd rest_list))
                else get_sum(tl rest_list)
            in
              (name, entries(tl record_splitted), get_sum(tl record_splitted))::record_split(tl str_list)
            end
        val splitted_record_list = record_split(record_list);
        fun entry_count(e_list: int list) : int = 
          if null e_list
          then 0
          else 1+entry_count(tl e_list)
        val e_count = entry_count(#2 (hd splitted_record_list))
        (* get input *)
        val input = read_stdin();
        val input_list = split_at(input, #"\n");
        val _ = print ("Read "^int_to_string(r_count)^" babies"^dot^" Starting year "^yearSt^dot^" Each baby has "^int_to_string(e_count)^" entries"^dot^"\n")
        (* search for each input name, print out stats data *)
        fun inputs_search (i_list : string list) : string = 
          if null i_list
          then ""
          else 
            let
              val name = hd i_list
              fun stats_output (record : string*(int list)*int) : string = 
                let
                  fun years (entries : int list): int = 
                    if null entries
                    then 0
                    else if hd entries = 0
                    then 0+years(tl entries)
                    else 1+years(tl entries)
                  
                  fun num2019 (year: int, entries : int list) : int = 
                    if year = 2019 
                    then hd entries
                    else num2019(year+1, tl entries)

                  fun first (year: int, entries : int list) : string = 
                    if hd entries >0
                    then int_to_string(year)^" "^int_to_string(hd entries)
                    else first(year+1, tl entries)
                  
                  fun last (year: int, entries : int list) : string = 
                    let
                      fun zero_list (l : int list) : bool = 
                        if null l
                        then true
                        else if hd l <> 0
                        then false
                        else zero_list(tl l) 
                    in
                      if hd entries > 0 andalso zero_list(tl entries)
                      then int_to_string(year)^" "^int_to_string(hd entries)
                      else last(year+1, tl entries)
                    end

                  fun min (year : int, min_year : int, mi : int, entries : int list) : string = 
                    if null entries
                    then int_to_string(min_year)^" "^int_to_string(mi)
                    else
                      let
                      in
                        if (mi = 0 andalso hd entries <> 0) orelse (hd entries < mi andalso hd entries <> 0)
                        then min (year+1, year, hd entries, tl entries)
                        else min (year+1, min_year, mi, tl entries)
                      end
                  
                  fun max (year : int, max_year : int, ma : int, entries : int list) : string = 
                    if null entries
                    then int_to_string(max_year)^" "^int_to_string(ma)
                    else
                      let
                      in
                        if hd entries > ma
                        then max (year+1, year, hd entries, tl entries)
                        else max (year+1, max_year, ma, tl entries)
                      end
              

                in 
                  "Total: "^int_to_string(#3 record)^"\n"^
                  "Years: "^int_to_string(years(#2 record))^"\n"^
                  "2019: "^int_to_string(num2019(valOf(fromString(yearSt)), (#2 record)))^"\n"^
                  "First: "^first(valOf(fromString(yearSt)), (#2 record))^"\n"^
                  "Last: "^last(valOf(fromString(yearSt)), (#2 record))^"\n"^
                  "Min: "^min(valOf(fromString(yearSt)), valOf(fromString(yearSt)), 0, (#2 record))^"\n"^
                  "Max: "^max(valOf(fromString(yearSt)), valOf(fromString(yearSt)), 0, (#2 record))^"\n"^
                  "Avg: "^real_to_string(int_to_real(#3 record) / int_to_real(e_count))^"\n"
                end

              fun name_search ( records: (string*(int list)*int) list) : string = 
                if null records
                then name^"\n Baby name ["^name^"] was not found \n"
                else if name = #1 (hd records)
                then name^"\n"^stats_output(hd records)
                else name_search(tl records)
              
            in
              name_search(splitted_record_list)^inputs_search(tl i_list)
            end
        val _ = print(inputs_search(input_list))
      in
        ()
      end
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
    
