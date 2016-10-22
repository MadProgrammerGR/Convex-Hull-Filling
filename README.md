# Convex-Hull-Filling

This Project makes a JFrame GUI window and displays a random convex hull. <br>
Then the convex hull gets filled with nice patterns and colors. <br>

I used <a href="https://en.wikipedia.org/wiki/Gift_wrapping_algorithm">Gift wrapping algorithm</a> to get the convex hull of random points.<br>
Then on Gui1 uses convex combination and Gui2 uses this formula recursively: <br>
<b> F(n) = L*F(n-1) - (1-L)*Xn </b> <br>
where L is in range [0-1] and Xn is the n-th point on convex hull.<br>

<i>project was made for practice and fun only!</i>
