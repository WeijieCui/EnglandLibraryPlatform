from flask import Flask, request, jsonify
from marshmallow import ValidationError

from src.schema import ModelSchema
from src.solver import Solver

app = Flask('scheduling',
            instance_relative_config=True,
            static_url_path='/scheduling/static',
            static_folder='./static',
            template_folder='./templates',
            )
app.config.from_pyfile('config.py')
model_schema = ModelSchema()


@app.route('/scheduling/api/v1.0/routing/car', methods=['POST'])
def routing_car():
    try:
        model = model_schema.load(request.get_json())
        solver = Solver(model)
        solution = solver.solve()
    except ValidationError as err:
        return jsonify(err.messages), 400
    except Exception as err:
        return jsonify({'error': str(err)}), 500
    return solution


if __name__ == '__main__':
    app.run(port=app.config['PORT'],
            threaded=app.config['THREADED'],
            passthrough_errors=app.config['PASSTHROUGH_ERRORS'])
