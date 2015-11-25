(ns simquant.render
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [simquant.core :as simquant]))

(defn setup []
  (q/smooth)
  {})

(defn update-state [state]
  state)

(defn draw-state [state]
  (q/background 30)
  (let [canvas-shortest-edge (min (q/width) (q/height))
        canvas-margin (* canvas-shortest-edge 0.15)
        canvas-max-x (- (q/width) canvas-margin)
        canvas-max-y (- (q/height) canvas-margin)
        x-scale (simquant/scale :linear [0 100] [canvas-margin canvas-max-x])
        y-scale (simquant/scale :linear [70 100] [canvas-max-y canvas-margin])
        dia-scale (simquant/scale :linear [0 1] [(* canvas-shortest-edge 0.001) (* canvas-shortest-edge 0.05)])
        diameter (dia-scale 1)]
    (doseq [[x y] (:data (simquant/user-record "Nils" "Weight"))]
      (q/ellipse (x-scale x) (y-scale y) diameter diameter))))

#_
(q/defsketch color-spectrum-circle
  :title "SimQuant"
  :size [800 400]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top :resizable]
  :middleware [m/fun-mode])
