(ns clojure-tic-tac-toe.player)

(defmulti play-turn (fn [game] (:player-type game)))
