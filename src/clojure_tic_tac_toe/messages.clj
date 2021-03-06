(ns clojure-tic-tac-toe.messages
  (:require [clojure.string :as string]
            [clojure-tic-tac-toe.rules :as rules])) 

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

(defn end-game [board]
  (if (rules/winner? board)
    (str (convert-to-string(rules/get-winner board)) " won! Congratulations!")
    (str "Game over! It's a tie!")))

(defn clear-screen []
  (do (print(str (char 27) "[2J"))
  (str (char 27) "[2J")))

(defn help []
  (str "Did not recognize game type. Please enter --type followed by a valid game type.\nValid game types: hvh, hvc"))
