## Benbria Loop™ Mobile SDK for Android

Increase retention and customer loyalty by improving the experience in real-time with visibility into performance. Escalate and remediate situations as they happen using in-moment feedback and offer solutions to problems customers are facing at the time.

## Table of contents

### Quick start

   * [How It Works](#how-it-works)
   * [Integrate the SDK into your app](#qs-integrate-sdk)
      * [Step 1: Download the SDK](#download-sdk)
      * [Step 2: Set up your Mobile Channel](#setup-mobile-channel)
      * [Step 3: Importing to Android Studio](#import-sdk)
      * [Step 4: Configure the Loop SDK](#configure-sdk)
   * [Further Details](#further-details)
      * [Presenting an experience to the customer](#presenting)
      * [Intercept-style experience presentation](#intercept)
   * [Issues and Bugs](#issues-and-bugs)
   * [FAQ](#faq)


### <a id="how-it-works"></a>How It Works

1. Log in to Loop™ management console and create a new mobile channel for your apps
2. Setup various experiences such as a survey about your app or a messaging channel to answer live questions
3. Integrate all those experiences into your mobile app using our [Mobile SDK](https://help.benbria.com/en/articles/3358712-loop-sdk-setup-java-on-android)
4. Close the loop with your customers live from your app

### <a id="qs-integrate-sdk"></a>Integrate the SDK into your app

#### <a id="download-sdk"></a>Step 1: Download the SDK
Download the [sample SDK repository](https://github.com/benbria/loop-sdk-android-sample/releases) or clone the repository.
```bash
git clone https://github.com/benbria/loop-sdk-android-sample.gitt
```
**OR**

Install via Maven (GitHub):
```xml
<dependency>
  <groupId>com.benbria</groupId>
  <artifactId>loop-android-sdk</artifactId>
  <version>1.0.3</version>
</dependency>
```
or Gradle (GitHub):
```groovy
maven {
            url "https://maven.pkg.github.com/benbria/loop-sdk-android"
            name "GitHubPackages"
            credentials {
                username = project.findProperty("github_username") ?: System.getenv("GITHUB_USER")
                password = project.findProperty("github_password") ?: System.getenv("TOKEN")
            }
        }
```

#### <a id="setup-mobile-channel"></a>Step 2: Set up your Mobile Channel
You must create your mobile channel and set up your survey/messaging experiences in your Loop management console.

1. Once your channel is created and you have some expreiences created, navigate to the channel detail page and click the **View SDK Codes** option
2. Copy the revealed information as it will be used to configure the SDK to connect to your newly created channel


#### <a id="import-sdk"></a>Step 3: Importing to Android Studio

1. From the menu bar, click **File -> New Module -> Import .JAR or .AAR package**
3. Navigate to and select the **loop-android-sdk-x.y.z.aar** (x.y.z being the current version) file and click Finish
4. In your **AndroidManifest.xml** file, make sure you've included the `<uses-permission android:name="android.permission.INTERNET"/>` permission
5. Make sure your **build.gradle** file has `compile project(':com.benbria:loop-android-sdk')` under `dependencies {}`

#### <a id="configure-sdk"></a>Step 4: Configure the Loop SDK

1. Import the SDK
`import import com.benbria.loopandroidsdk.core.Loop;` and the configuration class
`import com.benbria.loopandroidsdk.domain.entities.Configuration`
2. Initialize the SDK: `private Loop loopInstance = Loop.getInstance(this);`
3. Configure the SDK: `loopInstance.init(Configuration(mobileChannelId = "6054c5146df5a259081d52c2", accountId = "4f0f298c1808714405000002"))`

Look at the sample project in this repo for a detailed example.

### <a id="further-details"></a>Further Details

#### <a id="presenting"></a>Presenting an experience to the customer

Details coming soon

#### <a id="intercept"></a>Intercept-style experience presentation

Details coming soon

### <a id="issues-and-bugs"></a>Issues and Bugs
To report issues with the SDK, please contact us at support@benbria.com

### <a id="faq"></a>FAQ
*How can I drive engagement through my app using Loop?*

##### <a id=""></a>Receive customer feedback

Details coming soon

##### <a id=""></a>Measure product satisfaction

Details coming soon

##### <a id=""></a>Deliver real-time support

Details coming soon

*How do I present my mobile experiences?*

##### <a id=""></a>Passive feedback
Including as "Give Feedback" button in strategic places allows your users to provide feedback whenever they want.

##### <a id=""></a>Time-based trigger
You can set up predefined time intervals to show a specific experience to a random percentage of your users. For example, you can set the in-app feedback to prompt a user within 5 minutes after they open the app. Once shown, that user will not receive this specific prompt again, but more can be configured on the Loop console without having to modify the app.

##### <a id=""></a>Event-based triggers
You can show the user any experience based on which page or what action they take within the app. For example, after a successful purchase, a price satisfaction question can be shown or maybe a live chat can be started once a user goes back and forth between multiple pages, asking them if they need help finding what they are looking for.

*How can I route my app users to different flows based on their survey response?*

If you have a ADVANTAGE plan or higher, you can program your app to route your users into different flows based on their responses to your survey. For example, if a user responds to your in-app feedback survey and gives your app a 5-star rating, your app could take that user down the “5-Star Rating Flow” into the app store to rate your app. You could also take a user down the “Needs Improvement Flow” to the help center in your app.

*Is the mobile SDK free?*

Yes, the mobile SDK is free for all Loop customers with one or more mobile channel.

*How can I style my experiences?  How will it look on a mobile device?*

Everything around the experience is controlled by your app and the experiences themselves are customizable the same way all our channels are.

*Can I make edits once my app is deployed?*

Yes, each experience that was set within the app stays fully configurable from our Loop console.
