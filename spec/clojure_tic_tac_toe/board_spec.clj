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
  (describe "get-board"
    (it "returns an empty board"
      (should= [
                0 1 2
                3 4 5
                6 7 8
               ]
               (get-board empty-board))))
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
        (should= false (full? empty-board)))))
