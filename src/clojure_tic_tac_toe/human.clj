(ns clojure-tic-tac-toe.human
  (:require [clojure-tic-tac-toe.player :refer [play-turn]]
            [clojure-tic-tac-toe.console-ui :as console]
            [clojure-tic-tac-toe.messages :as messages]
            [clojure-tic-tac-toe.input-validation :refer [is-number?]]
            [clojure-tic-tac-toe.move-validation :refer [valid-move?]]
            [clojure-tic-tac-toe.board :as board]))

(defn- validate-move [input board]
 (if (valid-move? board input)
   input))

(defn- select-space[input board]
  (->
    (validate-move input board)))

(defmethod play-turn :human [game]
  (->
    (select-space (:input game) (:board game))
    (board/fill-board (:board game) (:current-player game))))
