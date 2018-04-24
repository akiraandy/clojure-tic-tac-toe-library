(ns clojure-tic-tac-toe.computer
  (:require [clojure-tic-tac-toe.board :as board]
            [clojure-tic-tac-toe.rules :as rules]))

(defn- choose-corner []
  (rand-nth [0 2 6 8]))

(defn- take-middle []
  4)

(defn- take-random-spot [board] 
  (if (not(empty?(board/available-spaces board)))
    (rand-nth (board/available-spaces board))))

(defn winning-move [board current-player] 
  (first(filter (fn [board-state] (not(nil? board-state))) 
    (for [space (board/available-spaces board)]
      (let [possible-board (board/fill-board space board current-player)]
        (if (rules/winner? possible-board)
          space))))))

(defn- select-space [board current-player opponent-player]
  (cond
  (board/board-empty? board) (choose-corner)
  (number? (winning-move board current-player)) (winning-move board current-player)
  (number? (winning-move board opponent-player)) (winning-move board opponent-player)
  (board/middle-available? board) (take-middle)
  :else (take-random-spot board))) 

(defn play-turn-computer [game]
  (-> 
    (select-space (:board game) (:current-player game) (:opponent-player game))
    (board/fill-board (:board game) (:current-player game))))
