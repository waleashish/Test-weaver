import React, { Component } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

class InputComponent extends Component {
    constructor(props) {
        super(props);
        this.state = { 'code' : '',
                        'framework' : '' }

        this.handleCodeInputChange = this.handleCodeInputChange.bind(this);
        this.handleFrameworkInputChange = this.handleFrameworkInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleCodeInputChange(event) {
        this.setState ({ code : event.target.value });
    }

    handleFrameworkInputChange(event) {
        this.setState ({ framework : event.target.value });
    }

    async handleSubmit(event) {
        event.preventDefault();
        const userData = {
            code: this.state.code,
            framework: this.state.framework
        }

        try {
            const response = await axios.post("http://localhost:8080/generate-test-cases", userData);
            console.log(response.data);
        } catch(error) {
            console.log("Error:", error);
        }
    }
    
    render() {
        return (
            <div className="d-flex flex-column align-items-center justify-content-center vh-100">
                <div className="card p-3 mt-2 mb-2 w-75 shadow">
                    <div className="card-body">
                        <div className="d-flex flex-row">
                            <div className="col-6 d-flex flex-column align-items-center justify-content-center">
                                <h1>Test Weaver</h1>
                                <h4>Smart Testcase Generator</h4>
                            </div>
                            <div className="col-6">
                                <div className="card p-3 mt-2 mb-2 shadow">
                                    <div className="card-body">
                                        <form onSubmit={this.handleSubmit} className="mb-3">
                                            <div className="form-group mb-3">
                                                <label>Code:</label>
                                                <textarea className="form-control" rows="10" value={this.state.code} onChange={this.handleCodeInputChange} />
                                            </div>
                                            <div className="form-group mb-3">
                                                <label>Testing Framework:</label>
                                                <input type="text" className="form-control" value={this.state.framework} onChange={this.handleFrameworkInputChange} />
                                            </div>
                                            <button type="submit" className="btn btn-primary">Submit</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default InputComponent;