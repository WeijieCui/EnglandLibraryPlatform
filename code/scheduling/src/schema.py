from marshmallow import Schema, fields, validate, validates, ValidationError


class ModelSchema(Schema):
    id = fields.Int(required=True)
    name = fields.Str(required=True)
    num_vehicles = fields.Int(required=True, validate=validate.Range(min=1))
    depot = fields.Int(required=True)
    distance_matrix = fields.List(fields.List(fields.Int()), required=True)
    pickups_deliveries = fields.List(fields.List(fields.Int(), validate=validate.Length(equal=2)), required=True)

    @validates('distance_matrix')
    def validate_distance_matrix(self, value):
        # Check that the matrix is square
        if not all(len(row) == len(value) for row in value):
            raise ValidationError('The distance matrix must be square.')

        # Check that all elements are non-negative
        if any(any(element < 0 for element in row) for row in value):
            raise ValidationError('All distances must be non-negative.')

        # Check that diagonal elements are zero
        if any(value[i][i] != 0 for i in range(len(value))):
            raise ValidationError('Diagonal elements must be zero.')

        # Check that the matrix is symmetric
        if any(value[i][j] != value[j][i] for i in range(len(value)) for j in range(len(value))):
            raise ValidationError('The distance matrix must be symmetric.')
