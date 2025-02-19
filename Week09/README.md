****Week 9 Video games data analytics****</br></br>
***Outline*** </br>
**9.1 Continue.. (SKLearn Multiflow)**
+ multiflow (folder)
    - skmultiflow-demo-scipy2020.ipynb [1]
    - jacob_montiel.pdf [2]
    - agr_a_20k.csv [1]

**9.2 Video game and data analytics**
+ Get python game from [4]
+ pip install pygame (If you don't have it.)
    - If you don't want to play the game in a fullscreen mode, you can comment line 419 of space_wars.py out and then uncomment line 418 of the same file.
+ Real-time data analytics in video games [5]
    - Which Metrics Matter?
    
| Metric	     | Definition & Use|
| ---------------| --------------- |
| ARPU (Average Revenue Per User) | Total number of unique players divided by total revenue in a given period. Can gauge the general business health of your game. |
| ARPPU (Average Revenue per Paying User) |	Like ARPU but limited to purchasing players. Useful for gauging monetization strategies, such as in-game store design or store price points.  |
| Unique Logins	| Fairly self-explanatory, used to monitor active player population.|
| Conversion Rate	| Total number of players who made purchases divided by unique logins. Gauges how well you convert free users into paid users.|
| Retention  | Total number of players that logged into your game during two specific date ranges. Common gaps between reporting periods are 1-day, 7-day, and 30-day measures.  |
| Avg. Session Length | Another self-explanatory metric, used to gauge how long your gameplay loop is fun or keeps players' attention.  |
| Session Frequency  | Number of players logged in, divided by the total number of login events. Gauges how often players engage with the game.   |
| LTV (Lifetime Value)  | Total number of unique players divided by total revenue generated. Gauges how high your ROI (return on investment) is per player.  |
| Errors  | Counts errors generated by code. Gauges how stable your game is.  |
| Content Logs  | Counts occurrences of specific logs unique to your game's content being triggered. Gauges popularity, stability, and engagement of specific content.  |

+ Best game document but Apache beam examples [7]


**9.3 Setup Kafka on AWS**


***Reference***

[1] Notebook: https://github.com/jacobmontiel/skmultiflow-demo-scipy2020/blob/master/skmultiflow-demo-scipy2020.ipynb </br>
[2] Paper: http://conference.scipy.org/proceedings/scipy2020/pdfs/jacob_montiel.pdf </br>
[3] His talk: https://www.youtube.com/watch?v=sw85SCv847Y </br>
[4] SpaceWars game: https://github.com/DanPetersson/SpaceWars.git </br>
[5] How to Implement Real-time Analytics in Online Games: https://developer.microsoft.com/en-us/games/blog/how-to-implement-real-time-analytics-in-online-games/ </br>
[6] Interesting info: https://scikit-learn.org/0.15/modules/scaling_strategies.html#incremental-learning </br>
[7] Apache beam: https://beam.apache.org/get-started/mobile-gaming-example/ </br>
[8] ADWIN: https://www.cs.upc.edu/~abifet/Prova/
