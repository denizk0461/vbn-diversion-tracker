## BSAG Diversion Tracker
This app is a very early work-in-progress, proof-of-concept diversion tracker for the tram and bus lines run by the Bremer Straßenbahn AG in Bremen, Germany.

## Goals
- View diversions
- View important messages (e.g. if an overhead wire was torn down and multiple tram lines have to be diverted temporarily)
- Pick priority lines
    - Only show diversions for lines relevant to the user
    - Send notifications to the user
- Unread markers
    - Show the user if a diversion has been added or modified to a diversion notice they have already viewed

## Challenges
I so far have no way of actually retrieving the diversions from the BSAG or their website. While the data is public, their website generates the windows in which the diversion texts are shown dynamically, which makes it nigh impossible to retrieve this data. I have a few ideas for this in mind, such as:
- Running a Selenium instance on a Raspberry Pi to run through the website every few minutes and upload this data to my GitHub Pages website
- Asking the BSAG (or VBN?) if they are able to provide this data through an API

As of now, I am creating this app as a proof-of-concept.

## Progress
- Viewing the lines works
- Nothing else has been implemented so far

## What's broken
um everything

## TODO
See [goals](#Goals).

## Why Android-only?
Because:
- I know Android development and it's a lot easier for me to work on an app using a framework I already know than to learn a new one while still trying to keep up with my responsibilities at university, and
- because Apple is a greedy company that charges thousands for laptops, phones, as well as $99 a year for a developer account, which are all requirements (sans the phone, if I was to use their simulator, which isn't ideal) and I, as a student, simply do not have the money for that.

I may reconsider once Apple finally opens up iOS for third-party apps.