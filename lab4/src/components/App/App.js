import React from 'react';
import axios from 'axios';
import ListView from '../ListView/ListView';
import './App.css';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {movie: [], tv: []}
  }
  componentDidMount() {
    axios.get('http://172.17.237.245:8080/hit/DoubanServlet?type=movie')
    .then((response) => {
      this.setState({movie: response.data.subjects});
    })
    .catch((err) => {
      console.log(err);
    });
    axios.get('http://172.17.237.245:8080/hit/DoubanServlet?type=tv')
    .then((response) => {
      this.setState({tv: response.data.subjects});
    })
    .catch((err) => {
      console.log(err);
    })
  }
  render() {    
    return (
      <div className="App">
        <ListView data={this.state.movie}/>
        <ListView data={this.state.tv}/>
      </div>
    );
  }
}
export default App;
