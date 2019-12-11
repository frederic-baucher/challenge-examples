#
# File executed when user click on `Submit` button.
#  It must test if the user has reach or not the solution
#  with many tests.
#  Also have to sys.exit(1) if something is wrong
#  And sys.exit(0) if everything was fine.
#
if __name__ == "__main__":
    import template
    import sys
    from mission_client import Mission

    score = template.score()
    Mission.done(score)
    print(f'Score : {score}')
