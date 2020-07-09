# Collision Point dans Rectangle

![Example image](${DEADLOCK_RESOURCE}/docs/images/example.png)

Hello, vous êtes sur la première mission de [l'aventure sur les collisions.](/story/7e0b1adc-980d-43af-88cb-091bcd523d7a/resume)  
Commençons par créer un test de collision,
le test le plus simple est celui pour tester si un point est dans un rectangle,
ce qui revient à tester si la souris est sur un joueur par exemple, ou si
on a cliqué dessus.

Dans la plupart des jeux 2D, surtout les points and click cet algorithme est
beaucoup utilisé.
Principalement parce que la plupart des sprites peuvent être représentés par un rectangle.

### Comment ça fonctionne ?

Nous allons vous donner un rectangle (Box), disons que c'est un joueur,
et un autre argument, un point, qui représente le curseur de la souris.
Et vous devrez répondre si oui **true** ou si non **false** le point est dans le rectangle.

```java
class Box {
    getX(): int
    getY(): int
    getWidth(): int
    getHeight(): int
}
class Point {
    getX(): int
    getY(): int
}
```

`getX()` et `getY()` pour la Box représentent les coordonnées du début du rectangle (le coin en bas à gauche), `getWidth()` retourne la longueur sur l'axe x
et `getHeight()` la hauteur sur l'axe y.


Nous sommes dans un plan cartésien tel que :

![Example image](${DEADLOCK_RESOURCE}/docs/images/plan.png)

La plupart du temps quand on utilise un moteur de jeu, ou simplement de quoi dessiner sur une fenêtre,
l'origine se trouve en haut à gauche de l'écran, nous ne prenons pas en compte ce détail pour notre exercice.
