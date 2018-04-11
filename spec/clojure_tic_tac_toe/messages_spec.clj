(ns clojure-tic-tac-toe.messages-spec
  (:require [speclj.core :refer :all]
            [clojure-tic-tac-toe.messages :refer :all]))

(def board
  [
   0 :x 2
   3 4 5
   6 7 8
  ]
)

(describe "Messages"
  (describe "convert-cell-to-string"
    (it "converts a board cell to a string"
      (should= "X"(convert-to-string (nth board 1)))))
  (describe "display-board"
    (it "displays a tic-tac-toe board"
      (should= (str " 0 | X | 2" "\n===+===+===\n " "3 | 4 | 5" "\n===+===+===\n " "6 | 7 | 8") (display-board board))))
  (describe "turn-prompt"
    (it "prompts the current player to take their turn"
      (should= "X's turn to play! Please select an available space" (turn-prompt :x))))
  (describe "invalid-input"
    (it "informs the user of invalid input"
      (should= "Invalid input detected, please input a number from 0-8" (invalid-input)))))
