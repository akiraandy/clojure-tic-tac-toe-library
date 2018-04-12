(ns clojure-tic-tac-toe.rules-spec
  (:require [speclj.core :refer :all]
            [clojure-tic-tac-toe.rules :refer :all]))

(describe "rules"
  (describe "winner?"
    (it "returns true if there is a winner on a row"
      (should= true (winner? [:x :x :x 3 4 5 6 7 8]))
      (should= true (winner? [0 1 2 :x :x :x 6 7 8]))
      (should= true (winner? [0 1 2 3 4 5 :x :x :x])))
    (it "returns true if there is a winner on a column"
      (should= true (winner? [:x 1 2 :x 4 5 :x 7 8]))
      (should= true (winner? [0 :x 2 3 :x 5 6 :x 8]))
      (should= true (winner? [0 1 :x 3 4 :x 6 7 :x])))
    (it "returns true if there is a winner on a diagonal"
      (should= true (winner? [:x 1 2 3 :x 5 6 7 :x]))
      (should= true (winner? [0 1 :x 3 :x 5 :x 7 8])))
    (it "returns false if there is not a winner on the board"
      (should= false (winner? [:x :o :x 3 :x 5 6 7 8]))))
  (describe "tie?"
    (it "returns true if there is a tie"
        (should= true (tie? [:o :o :x :x :x :o :o :o :x])))
    (it "returns false if there is not a tie"
        (should= false (tie? [0 :x :o 3 4 5 :x :o 8]))))
  (describe "get-winner"
    (it "returns the winner for X"
      (should= :x (get-winner [:x :x :x 3 4 5 6 7 8])))
    (it "returns the winner for O"
      (should= :o (get-winner [0 1 2 :o :o :o 6 7 8])))
    (it "returns nil if there is no winner"
      (should= nil (get-winner [0 1 2 3 4 5 6 7 8]))))
  (describe "game-over?"
    (it "returns true if a player has won"
      (should= true (game-over? [:x :x :x :o 4 5 6 7 8])))
    (it "returns true if there is a tie"
      (should= true (game-over? [:o :o :x :x :x :o :o :o :x])))
    (it "returns false if the game is not over"
      (should= false (game-over? [:x :o :o :x 4 5 6 7 8])))))
