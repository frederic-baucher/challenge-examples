# Collision Dot in Box

![Example image](${DEADLOCK_RESOURCE}/docs/images/example.png)

Hi there, you are on the first mission of [story of collisions.](/story/7e0b1adc-980d-43af-88cb-091bcd523d7a/resume)  
Let'start by creating a collision test,
the simplest test is the one for testing if a dot is in a box,
which is amount to testing if the computer mouse is on a player for example, or if
we clicked on it.

In most 2D games, especially points and click, this algorithm is used a lot.
Mainly because the most of the sprites can be represented by a box.

### How does it work ?
We will give you a box, let's say it's a player,
and another argument, a dot, which represents the computer mouse.
And you will have to answer if yes **true** or no **false** the dot is in the box.

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
getX() and getY() for the box represent the beginning of the box, getWidth() the length on the x axis,
and getHeight() the height on the y axis.

We are in a cartesian plane such as:

![Example image](${DEADLOCK_RESOURCE}/docs/images/plan.png)

Most of the time the game engines, or just what to draw on a window,
the origin is at the top left of the screen, we do not consider this detail for our exercise
