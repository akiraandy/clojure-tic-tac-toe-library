(ns clojure-tic-tac-toe.board-spec
  (:require [speclj.core :refer :all]
            [clojure-tic-tac-toe.board :refer :all]))

(def empty-board
  [
   0 1 2
   3 4 5
   6 7 8
  ])

(def not-empty-board
  [
   0 :x 2
   :o 4 5
   6 7 8
  ])

(def full-board
  [
   :x :o :x
   :x :o :o
   :o :x :o 
  ])

(describe "Board"
    (describe "available-spaces"
      (it "returns a vector of available spaces"
        (should= [0 2 4 5 6 7 8]
                 (available-spaces not-empty-board))))
    (describe "fill-board"
      (it "adds a marker to the board"
        (should= [
                  0 1 2
                  3 :x 5
                  6 7 8
                 ] (fill-board 4 empty-board :x))))
    (describe "full?"
      (it "returns true if the board is full"
        (should= true (full? full-board)))
      (it "returns false if the board is not full"
        (should= false (full? empty-board))))
    (describe "empty?"
      (it "returns true if the board is empty"
        (should= true (board-empty? empty-board)))
      (it "returns false if the board is not empty"
        (should= false (board-empty? not-empty-board))))
    (describe "middle-available?"
      (it "returns true if middle is available"
        (should= true (middle-available? empty-board)))
      (it "returns false if middle is unavailable"
        (should= false (middle-available? full-board)))))
