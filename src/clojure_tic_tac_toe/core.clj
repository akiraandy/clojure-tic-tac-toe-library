(ns clojure-tic-tac-toe.core
  (:require [clojure-tic-tac-toe.console-ui :as console-ui]
            [clojure-tic-tac-toe.board :as board]
            [clojure-tic-tac-toe.messages :as messages]))
(def empty-board 
  [0 1 2 3 4 5 6 7 8])

(defn -main
  [& args]
  (console-ui/print-message (messages/display-board (board/get-board empty-board))))
