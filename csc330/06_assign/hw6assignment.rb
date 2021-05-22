# Programming Languages, Homework 6, hw6runner.rb

# This is the only file you turn in,
# so do not modify the other files as
# part of your solution.

class MyPiece < Piece
  # The constant All_My_Pieces should be declared here:
  All_My_Pieces=[[[[0, 0], [1, 0], [0, 1], [1, 1]]],  # square (only needs one)
                  rotations([[0, 0], [-1, 0], [1, 0], [0, -1]]), # T
                  [[[2, 0], [1, 0], [0, 0], [-1, 0]], # long (only needs two)
                  [[0, 2], [0, 1], [0, 0], [0, -1]]],
                  rotations([[0, 0], [0, -1], [0, 1], [1, 1]]), # L
                  rotations([[0, 0], [0, -1], [0, 1], [-1, 1]]), # inverted L
                  rotations([[0, 0], [-1, 0], [0, -1], [1, -1]]), # S
                  rotations([[0, 0], [1, 0], [0, -1], [-1, -1]]), # Z
                  [[[2, 0], [1, 0], [0, 0], [-1, 0], [-2,0]], # 5-cube long 
                  [[0, 2], [0, 1], [0, 0], [0, -1], [0,-2]]],
                  rotations([[0, 0], [0, -1], [1, 0]]), # short L
                  rotations([[0, 0], [0, -1], [1, -1], [1, 0], [2, 0]])]

  # Your Enhancements here
  def self.next_piece (board)
    MyPiece.new(All_My_Pieces.sample, board)
  end
  

end

class MyBoard < Board
  # Your Enhancements here:
  def initialize (game)
    @grid = Array.new(num_rows) {Array.new(num_columns)}
    @current_block = MyPiece.next_piece(self)
    @score = 0
    @game = game
    @delay = 500
    @cheat=false
  end

  def rotate_180_degree
    rotate_clockwise
    rotate_clockwise
  end

  def next_piece
    if @cheat
      @cheat=false
      @current_block = MyPiece.new([[[0, 0]]], self)
    else
      @current_block = MyPiece.next_piece(self)
    end
    
    @current_pos = nil
  end

  def store_current
    locations = @current_block.current_rotation
    displacement = @current_block.position
    len = locations.length
    (0..(len-1)).each{|index| 
      current = locations[index];
      @grid[current[1]+displacement[1]][current[0]+displacement[0]] = 
      @current_pos[index]
    }
    remove_filled
    @delay = [@delay - 2, 80].max
  end

  def cheat
    if (@score<100 or @cheat==true)
      return
    end
    @score-=100
    @cheat=true


  end

end

class MyTetris < Tetris
  # Your Enhancements here:
  def set_board
    @canvas = TetrisCanvas.new
    @board = MyBoard.new(self)
    @canvas.place(@board.block_size * @board.num_rows + 3,
                  @board.block_size * @board.num_columns + 6, 24, 80)
    @board.draw
  end

  def key_bindings  
    @root.bind('n', proc {self.new_game}) 

    @root.bind('p', proc {self.pause}) 

    @root.bind('q', proc {exitProgram})
    
    @root.bind('a', proc {@board.move_left})
    @root.bind('Left', proc {@board.move_left}) 
    
    @root.bind('d', proc {@board.move_right})
    @root.bind('Right', proc {@board.move_right}) 

    @root.bind('s', proc {@board.rotate_clockwise})
    @root.bind('Down', proc {@board.rotate_clockwise})

    @root.bind('w', proc {@board.rotate_counter_clockwise})
    @root.bind('Up', proc {@board.rotate_counter_clockwise}) 

    @root.bind('u', proc {@board.rotate_180_degree}) 

    @root.bind('space' , proc {@board.drop_all_the_way}) 

    @root.bind('c' , proc {@board.cheat})
  end

end

#PART II

class MyPieceChallenge < MyPiece

  def initialize (point_array, board)
    @all_rotations = Marshal.load(Marshal.dump(point_array))
    @rotation_index = (0..(@all_rotations.size-1)).to_a.sample
    @color = All_Colors.sample
    @base_position = [5, 0] # [column, row]
    @board = board
    @moved = true
    @is_snake = point_array.length==2 
    @all_rotations = Marshal.load(Marshal.dump(point_array))+[Marshal.load(Marshal.dump(point_array[0])).reverse, Marshal.load(Marshal.dump(point_array[1])).reverse] if @is_snake
  end

  def self.next_piece (board)
    MyPieceChallenge.new(All_My_Pieces.sample, board)
  end

  def transform direct
    directs=Array.new(4)
    if @rotation_index==1
      directs[0] = [direct[1],-direct[0]]
    elsif @rotation_index==2
      directs[0] = [-direct[0],-direct[1]]
    elsif @rotation_index==3
      directs[0] = [-direct[1],direct[0]]
    else 
      directs[0] = [direct[0], direct[1]]
    end
    directs[1]=[-directs[0][1],directs[0][0]]
    directs[2]=[-directs[0][0], -directs[0][1]]
    directs[3]=[directs[0][1], -directs[0][0]]
    (0..3).each{|i| 
                    head=@all_rotations[i][0]
                    @all_rotations[i].pop
                    @all_rotations[i].unshift([head[0]+directs[i][0], head[1]+directs[i][1]])}
    
    print(@all_rotations[@rotation_index])
    print("\n")
    
  end

  def is_snake
    @is_snake
  end
end

class MyBoardChallenge < MyBoard

  def initialize (game)
    @grid = Array.new(num_rows) {Array.new(num_columns)}
    @current_block = MyPieceChallenge.next_piece(self)
    @score = 0
    @game = game
    @delay = 500
    @cheat=false
  end

  def is_snake
    @current_block.is_snake
  end


  def next_piece
    if @cheat
      @cheat=false
      @current_block = MyPieceChallenge.new([[[0, 0]]], self)
    else
      @current_block = MyPieceChallenge.next_piece(self)
    end
    
    @current_pos = nil
  end

  def snake_move direct
    if !game_over? and @game.is_running? and is_snake
      head = @current_block.current_rotation[0]
      new_item = [head[0]+direct[0], head[1]+direct[1]]
      if !@current_block.current_rotation.any?{|ele| ele[0]==new_item[0] && ele[1]==new_item[1] } && empty_at([new_item[0]+@current_block.position[0], new_item[1]+@current_block.position[1]]) && @score >= 10
        @current_block.transform direct
        @score-=10
      end
    end
    draw
  end
end

class MyTetrisChallenge < MyTetris
  def set_board
    @canvas = TetrisCanvas.new
    @board = MyBoardChallenge.new(self)
    @canvas.place(@board.block_size * @board.num_rows + 3,
                  @board.block_size * @board.num_columns + 6, 24, 80)
    @board.draw
  end

  def key_bindings  
    @root.bind('n', proc {self.new_game}) 

    @root.bind('p', proc {self.pause}) 

    @root.bind('q', proc {exitProgram})

    @root.bind('a', proc {@board.move_left})
    @root.bind('Left', proc {@board.move_left}) 
    
    @root.bind('d', proc {@board.move_right})
    @root.bind('Right', proc {@board.move_right}) 

    @root.bind('s', proc {@board.rotate_clockwise})
    @root.bind('Down', proc {@board.rotate_clockwise})

    @root.bind('w', proc {@board.rotate_counter_clockwise})
    @root.bind('Up', proc {@board.rotate_counter_clockwise}) 

    @root.bind('u', proc {@board.rotate_180_degree}) 
    
    @root.bind('space' , proc {@board.drop_all_the_way}) 

    @root.bind('c' , proc {@board.cheat})

    # snake move keys, only for 5-cube long
    @root.bind('j', proc {@board.snake_move([-1,0])})

    @root.bind('l', proc {@board.snake_move([1,0])})

    @root.bind('k', proc {@board.snake_move([0,1])})

    @root.bind('i', proc {@board.snake_move([0,-1])})
  end
end