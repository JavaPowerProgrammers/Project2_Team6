import { configureStore } from "@reduxjs/toolkit";

import mainReducer from "./mainReducerState";

export default configureStore(
  {
    reducer: {
      main: mainReducer,
    }
  }
);
