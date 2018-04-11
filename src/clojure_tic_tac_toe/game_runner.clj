(ns clojure-tic-tac-toe.game-runner
  (:require [clojure.string :as string]
            [clojure-tic-tac-toe.board :as board]
            [clojure-tic-tac-toe.player :as player]
            [clojure-tic-tac-toe.turn-controller :as turn-contr]))

(defn turn [gameboard]
  (player/play-turn {:player-type :human :board gameboard :current-player (turn-contr/current-player gameboard)}))

(defn game-loop [board]
  (if (board/full? board)
    board
  (recur (turn board))))
