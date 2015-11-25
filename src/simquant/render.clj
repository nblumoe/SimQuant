(ns simquant.render
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [simquant.core :as simquant]))

(defn setup []
  (q/no-cursor)
  (q/smooth)
  {})

(defn update-state [state]
  state)

(defn draw-state [state]
  (q/scale 1 -1)
  (q/scale 2)
  (q/background 30)
  (q/translate 100 -150)
  (doseq [[x y] (:data (simquant/user-record "Nils" "Weight"))]
    (q/ellipse x y 10 10)))

#_
(q/defsketch color-spectrum-circle
  :title "SimQuant"
  :size [800 400]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top :resizable]
  :middleware [m/fun-mode])
