(ns simquant.render
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [simquant.core :as simquant]))

(defn setup []
  (q/no-cursor)
  (q/smooth)
  (simquant/user-record "Nils" "Weight"))

(defn update-state [state]
  state)

(defn draw-state [{:keys [data]}]
  (q/translate 100 0)
  (q/background 30)
  (doseq [[x y] data]
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
