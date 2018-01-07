import * as React from "react";
import * as ReactDOM from "react-dom";
import "../../index.css";
import LanguageList from "../languages/language-list";

class App extends React.Component<{}, {}> {

    public render() {
        return(
            <div className="container">
               <LanguageList/>
            </div>
        );
    }
}

ReactDOM.render(<App/>, document.getElementById("app"));

