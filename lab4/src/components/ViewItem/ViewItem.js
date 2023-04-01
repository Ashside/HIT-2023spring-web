/* eslint-disable jsx-a11y/alt-text */
import React from 'react';
import './ViewItem.css';
export default class ViewItem extends React.Component {
    render() {
        return (
            <div className="ViewItem">
                <a href={this.props.url} target="_blank" rel="noreferrer"><img src={this.props.cover}/></a>
                <div className="txt" style={{display: 'flex', justifyContent: 'space-between'}}>
                    <a href={this.props.url} target="_blank" rel="noreferrer">
                    <span id="title">{this.props.title.substring(0,7)}</span>
                    </a>
                    <span id="rate">{this.props.rate}</span>
                </div>
            </div>
        )
    }
}