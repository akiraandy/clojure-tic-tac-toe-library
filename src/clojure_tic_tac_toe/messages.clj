(ns clojure-tic-tac-toe.messages
  (:require [clojure.string :as string])) 

(defn convert-to-string [cell]
  (if (number? cell)
    (str cell)
    (string/upper-case (name cell))))

(defn display-board [board]
  (str " "(convert-to-string (nth board 0)) " | "
          (convert-to-string (nth board 1)) " | "
          (convert-to-string (nth board 2))
          "\n===+===+===\n "
          (convert-to-string (nth board 3)) " | "
          (convert-to-string (nth board 4)) " | "
          (convert-to-string (nth board 5))
          "\n===+===+===\n "
          (convert-to-string (nth board 6)) " | "
          (convert-to-string (nth board 7)) " | "
          (convert-to-string (nth board 8))))

(defn turn-prompt [current-player]
  (str (convert-to-string current-player) "'s turn to play! Please select an available space")
  )

(defn invalid-input []
  "Invalid input detected, please input a number from 0-8"
  )
