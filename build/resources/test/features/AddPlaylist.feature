@PlaylistFeature
Feature: Add to playlist music

  @AddPlaylist
  Scenario: Add to playlist music from search bar
    Given user is on the open url page
    And user click search bar
    And user input the keyword and click enter
    When the app will show the result
    And user will click the result
    And the app will play the music
    And user will click three dots in player
    And user will click add to playlist
    Then user will click the playlist and added to playlist