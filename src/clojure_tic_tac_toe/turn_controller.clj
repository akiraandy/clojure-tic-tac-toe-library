(ns clojure-tic-tac-toe.turn-controller
  (:require [clojure-tic-tac-toe.board :as board]))

(defn current-player [board]
  (if(odd? (count (board/available-spaces board)))
    :x
    :o))

(defn opponent-player [board]
  (if(odd? (count (board/available-spaces board)))
    :o
    :x))
