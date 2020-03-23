# minigame

To run application, use mvn spring-boot:run

User starts with level 1. When he/she enters correct the numbers of words, he will be rated to next level.
When the user answers correctly, the point increase and also there is a message to show the result is correct.
When the user answers incorrectly, the point increase and also there is a message to show the result is incorrect.
When the user reaches the next level, a new star is added.
User can surrender to restart the game.

Architecture:
_ springboot: this is just small and very simple application, we can use the benefit of the embedded server and also a small @Autowired
_ primefaces: this one is for UI. Primefaces is not a nice thing to compare react or angular but it is a good technology to use.
