(ns clojure-tic-tac-toe.human-spec
  (:require [speclj.core :refer :all]
            [clojure-tic-tac-toe.player :refer [play-turn]]
            [clojure-tic-tac-toe.human :refer :all]))

(def empty-board 
  [
   0 1 2
   3 4 5
   6 7 8
  ]
)

(describe "human"
  (describe "play-turn"
    (around [it]
      (with-out-str (it)))
    (it "should return a board with a new marker on it"
      (should= [
                :x 1 2
                3 4 5
                6 7 8
               ] (with-in-str "0"
                   (play-turn {:player-type :human :board empty-board :current-player :x}))))))
