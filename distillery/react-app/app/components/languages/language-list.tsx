import * as React from "react";

const Language: any = (props: any) => {

    return (
        <li>
            {props.name}
        </li>
    );
}

export default class LanguageList extends React.Component<any, any> {

    public render() {
        const langs: string[] = ["All", "JavaScript", "Ruby", "Java", "CSS", "Python"];

        return (
            <ul className="lang-container">
                {langs.map(lang => <Language key = {lang} name={lang}/>)}
            </ul>
        );
    }
}