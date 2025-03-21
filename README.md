Hello! this is my code repository for the exercise at Fetch (https://fetch-hiring.s3.amazonaws.com/mobile.html)

I spent 4 hours to get to a good deliverable state (commit: https://github.com/andretortolano/fetchhiring/commit/4ce2ced2ec012f6dd8ac6ae6e950e94957adc46c)

I mostly focused on getting the task done and then looking into areas I could tackle with the remaining time. for instance:

* Keeping future "modules" isolated from one another
* Customized the Theme to match some of Fetch's colors
* Desining a Custom Composable (FetchCard)
* Adding Koin as the DI framework
* Making viewModel emmits a UiState as single source of truth for the UI Layer

These are the remaining prioritized list tasks if I were to continue working on this project

1. Properly Handle Exception
2. Add Room and locally store when we get response from the web
3. Prefetch from local for faster loading time
4. Fallback to existing local data when there is an error on the request
5. improve apperance of splash screen and app icon
6. Add unit test to different layers of the application
7. Add compose ui test
8. Modularize (separate domain/data and features from the main app module)
