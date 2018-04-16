(ns clojure-tic-tac-toe.turn-controller-spec
  (:require [speclj.core :refer :all]
            [clojure-tic-tac-toe.turn-controller :refer :all]))

(def empty-board
  [
   0 1 2
   3 4 5
   6 7 8
   ]
  )

(def board
  [
   0 1 :x
   3 4 5
   6 7 8
   ]
  )

(describe "turn-controller"
  (describe "current-player"
    (it "should return X if available spaces are odd"
        (should= :x (current-player empty-board)))
    (it "should return O if available spaces are even"
        (should= :o (current-player board))))
  (describe "opponent-player"
    (it "should return O if available spaces are odd"
        (should= :o (opponent-player empty-board)))
    (it "should return X if available spaces are even"
        (should= :x (opponent-player board)))))
