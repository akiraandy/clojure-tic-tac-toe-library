(ns clojure-tic-tac-toe.player
  (:require 
    [clojure-tic-tac-toe.rules :as rules]
    [clojure-tic-tac-toe.move-validation :refer [valid-move?]]
    [clojure-tic-tac-toe.board :as board]))

(defmulti play-turn (fn [game] (contains? game :input) (and(not(nil?(game :input))))))

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

(defn- select-space-computer [board current-player opponent-player]
  (cond
  (board/board-empty? board) (choose-corner)
  (number? (winning-move board current-player)) (winning-move board current-player)
  (number? (winning-move board opponent-player)) (winning-move board opponent-player)
  (board/middle-available? board) (take-middle)
  :else (take-random-spot board))) 

(defmethod play-turn false [game]
  (-> 
    (select-space-computer (:board game) (:current-player game) (:opponent-player game))
    (board/fill-board (:board game) (:current-player game))))

(defn- validate-move [input board]
 (if (valid-move? board input)
   input))

(defn- select-space-human [input board]
  (->
    (validate-move input board)))

(defmethod play-turn true [game]
  (->
    (select-space-human (:input game) (:board game))
    (board/fill-board (:board game) (:current-player game))))
