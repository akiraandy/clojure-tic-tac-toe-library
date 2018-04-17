(ns clojure-tic-tac-toe.game-runner
  (:require [clojure.string :as string]
            [clojure-tic-tac-toe.board :as board]
            [clojure-tic-tac-toe.console-ui :as console]
            [clojure-tic-tac-toe.messages :as messages]
            [clojure-tic-tac-toe.rules :as rules]
            [clojure-tic-tac-toe.player :as player]
            [clojure-tic-tac-toe.turn-controller :as turn-contr]))

(defn switch-player-type [player-type] 
  (if (= player-type :human)
    :computer
    :human
  ))

(defn turn [gameboard player-type]
  (player/play-turn {:player-type player-type :board gameboard :current-player (turn-contr/current-player gameboard)}))

(defn game-loop-hvh [board player-type]
  (if (rules/game-over? board)
    board
  (recur (turn board :human) :human)))

(defn game-loop-hvc [board player-type]
  (if (rules/game-over? board)
    board
  (let [new-player-type (switch-player-type player-type)]
    (recur (turn board player-type) new-player-type))))

(defmulti play-game (fn [game-params] (:game-type game-params))) 

(defmethod play-game :hvc [params]
  (let [end-state (game-loop-hvc (:board params) :human)]
    (console/print-message(messages/clear-screen))
    (console/print-message(messages/display-board end-state))
    (console/print-message(messages/end-game end-state))))

(defmethod play-game :hvh [params]
  (let [end-state (game-loop-hvh (:board params) :human)]
    (console/print-message(messages/clear-screen))
    (console/print-message(messages/display-board end-state))
    (console/print-message(messages/end-game end-state))))

(defmethod play-game :default [params] 
  (throw (IllegalArgumentException.
           (str "There is no game type of " (:game-type params) ". " "Valid game types: -t hvh, -t hvc"))))
