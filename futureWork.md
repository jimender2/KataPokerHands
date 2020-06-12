# Future work

If I were to continue work on this project I would change a few things about how I went about it from the start.

First - I would use more classes / methods to try to break up the compareTo method in the hand.java file.  Currently there is a lot of extra code that can easily be handeled in smaller classes/methods.

Second - I would rewrite the scoring class to be more efficient and possbibly be called when I create a hand. Due to how I have mine set up right now, if I overwrite my score variable, it will need to be recalculated even though the score is not adjusted.

Third - Expand out the deck class so that it can keep track of its size and "get" a new deck when needed.  I would also add a way to make a hand directly from the deck class so that I do not need to call deck.remove 5 times to make a new hand.
