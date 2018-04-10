(ns clojure-tic-tac-toe.core
  (:require [clojure-tic-tac-toe.console-ui :as console-ui]
            [clojure-tic-tac-toe.board :as board]
            [clojure-tic-tac-toe.messages :as messages]
            [clojure-tic-tac-toe.game-runner :refer :all]))


(def empty-board 
  [0 1 2 3 4 5 6 7 8])

(def full-board
  [:x :x :x :x :x :x :x :x])

(defn -main
  [& args]
  (print(game-loop empty-board)))

