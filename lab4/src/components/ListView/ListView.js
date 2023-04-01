import React from 'react';
import ViewItem from '../ViewItem/ViewItem'
import './ListView.css';
export default class ListView extends React.Component {
    render() { 
        return (            
            <div className="ListView">
                {
                    this.props.data && this.props.data.map((item) => {
                        return (
                        <ViewItem
                            key={item.id} 
                            cover={item.cover} 
                            url={item.url}
                            title={item.title}
                            rate={item.rate}
                        />)
                        }
                    )
                }
            </div>
        )
    }
}