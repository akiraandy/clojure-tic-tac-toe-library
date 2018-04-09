(ns clojure-tic-tac-toe.board-spec
  (:require [speclj.core :refer :all]
            [clojure-tic-tac-toe.board :refer :all]))

(def empty-board
  [
   0 1 2
   3 4 5
   6 7 8
  ])

(describe "Board"
  (describe "get-board"
    (it "returns an empty board"
      (should= [
                0 1 2
                3 4 5
                6 7 8
               ]
               (get-board empty-board)))))
  
