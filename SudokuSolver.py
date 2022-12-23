# SudokuSolver.py
# @description simple sudoku solver
# @author Tenzin Tsomo
# @version 1.0 2021-09-22

def is_valid(board, row, col, num):
  # check row
  for c in range(9):
    if board[row][c] == num:
      return False
  # check column
  for r in range(9):
    if board[r][col] == num:
      return False
  # check 3x3 block
  start_row = row - row % 3
  start_col = col - col % 3
  for r in range(3):
    for c in range(3):
      if board[start_row + r][start_col + c] == num:
        return False
  return True

def solve(board):
  for row in range(9):
    for col in range(9):
      if board[row][col] == 0:
        for num in range(1, 10):
          if is_valid(board, row, col, num):
            board[row][col] = num
            if solve(board):
              return True
            board[row][col] = 0
        return False
  return True

def main():
  # test sudoku
  board = [
    [5, 3, 0, 0, 7, 0, 0, 0, 0],
    [6, 0, 0, 1, 9, 5, 0, 0, 0],
    [0, 9, 8, 0, 0, 0, 0, 6, 0],
    [8, 0, 0, 0, 6, 0, 0, 0, 3],
    [4, 0, 0, 8, 0, 3, 0, 0, 1],
    [7, 0, 0, 0, 2, 0, 0, 0, 6],
    [0, 6, 0, 0, 0, 0, 2, 8, 0],
    [0, 0, 0, 4, 1, 9, 0, 0, 5],
    [0, 0, 0, 0, 8, 0, 0, 7, 9]
  ]
  if solve(board):
    for row in board:
      print(row)
  else:
    print('No solution found')

main()
