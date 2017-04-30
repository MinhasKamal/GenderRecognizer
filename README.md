# :couple: Gender Recognizer 

[![Gitter](https://badges.gitter.im/MinhasKamal/GenderRecognizer.svg)](https://gitter.im/MinhasKamal/GenderRecognizer?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=body_badge)

#### Plain Face Detector & Gender Recognizer

[![Join the chat at https://gitter.im/MinhasKamal/GenderRecognizer](https://badges.gitter.im/MinhasKamal/GenderRecognizer.svg)](https://gitter.im/MinhasKamal/GenderRecognizer?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Give image of a person (frontal face), and [this program](http://minhaskamal.github.io/GenderRecognizer) will try to recognize male and female using **Template Matching**. Face detection part is accomplished using OpenCV.

### How to Run?
1. Import the project in IDE, & integrate [OpenCV](http://opencv.org) in the build path. Follow [this](http://docs.opencv.org/2.4/doc/tutorials/introduction/java_eclipse/java_eclipse.html) link for installing OpenCV in Java project.
2. For training the machine run [**Train.java**](https://github.com/MinhasKamal/GenderRecognizer/blob/master/src/com/minhaskamal/genderRecognizer/Train.java).
3. For testing run [**Predict.java**](https://github.com/MinhasKamal/GenderRecognizer/blob/master/src/com/minhaskamal/genderRecognizer/Predict.java) (change file-paths in the *main* method according to need).

### Visual of Learned Templates
  <div align="center">
  <img src="https://cloud.githubusercontent.com/assets/5456665/13002798/83f965a0-d19b-11e5-867a-26abfc4f08d8.png" height="100" width=auto title="Male">
  <img src="https://cloud.githubusercontent.com/assets/5456665/13002976/e8dc9a04-d19c-11e5-979a-363db5f6b1a4.jpg" height="100" width=auto title="Male">
  <img src="https://cloud.githubusercontent.com/assets/5456665/13002797/83f8a84a-d19b-11e5-93e7-95fe759b5faa.png" height="100" width=auto title="Female">
  <img src="https://cloud.githubusercontent.com/assets/5456665/13002977/e8df20f8-d19c-11e5-81ac-ce5b1c96dcf8.jpg" height="100" width=auto title="Female">
  </div>

### License
<a rel="license" href="https://opensource.org/licenses/MIT"><img alt="MIT License" src="https://cloud.githubusercontent.com/assets/5456665/18950087/fbe0681a-865f-11e6-9552-e59d038d5913.png" width="60em" height=auto/></a><br/><a href="https://github.com/MinhasKamal/DownGit">GenderRecognizer</a> is licensed under <a rel="license" href="https://opensource.org/licenses/MIT">MIT License</a>.
