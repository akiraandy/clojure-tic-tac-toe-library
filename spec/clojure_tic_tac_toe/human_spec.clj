(ns clojure-tic-tac-toe.human-spec
  (:require [speclj.core :refer :all]
            [clojure-tic-tac-toe.player :refer [play-turn]]
            [clojure-tic-tac-toe.human :refer :all]))

(def empty-board 
  [
   0 1 2
   3 4 5
   6 7 8
  ])

(def played-board
  [
   0 :x 2
   :o 4 5
   6 7 8
   ])

(describe "human"
  (describe "play-turn"
    (it "should return a board with a new marker on it"
      (should= [
                :x 1 2
                3 4 5
                6 7 8
               ] 
                   (play-turn {:player-type :human :board empty-board :input 0 :current-player :x})))
      (it "should return the same board if invalid move made"
        (should= [0 :x 2 :o 4 5 6 7 8] (play-turn {:player-type :human :board played-board :input 3 :current-player :x})))))
