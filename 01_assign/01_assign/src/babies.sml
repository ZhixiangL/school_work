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
          if null list
          then []
          else 
            let 
              val record = hd str_list
              val record_splited = split_at(record, #",")
              val name = hd record_splited;
              fun entries rest_list : int list =
                if null (tl rest_list)
                then []
                else fromString(hd rest_list) :: entries(tl rest_list)
              fun get_sum rest_list : int =
                if null (tl rest_list)
                then fromString(hd rest_list)
                else get_sum(tl rest_list)
            in
              (name, entries(tl record_split), get_sum(tl record_split))::record_split(tl str_list)
            end
        val splitted_record_list = record_split(record_list);
        fun entry_count(e_list: int list) : int = 
          if null e_list
          then 0
          else 1+entry_count(tl e_list)
        val _ = print ("Read "^r_count^" babies"^dot^" Starting year "^yearSt^dot^" Each baby has "^entry_count(#2 (hd splitted_record_list))^" entries"^dot^"\n")
        (* get input *)
        val input = read_stdin();
        val input_list = split_at(input, #"\n");

        (* search for each input name, print out stats data *)
      in
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
    
