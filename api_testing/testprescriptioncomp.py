import json
from API.prescriptioncomp   import PrescriptionComp

print('TESTING PRESCRIPTIONCOMP STARTED')

print('LIST1 test started!')
com_test    = PrescriptionComp()
_list       = json.loads(com_test.list())
print(json.dumps(_list, indent=4))
print('LIST1 test complete!')

print('LIST2 test started!')
max_pre_id  = max([x['prescription_id'] for x in _list])
_list       = json.loads(com_test.list(max_pre_id))
print(json.dumps(_list, indent=4))
print('LIST2 test complete!')

print('GET test started!')
max_com_id  = max([x['commodity_id'] for x in _list])
obj         = com_test.get(max_pre_id, max_com_id)
print(obj)
print('GET test complete!')

print('CREATE test started!')
com_test.setJson(max_pre_id, 5, 5.5, 0.5)
response    = com_test.create(com_test.json)
print(response)
print('CREATE test complete')

print('UPDATE test started!')
com_test.setJson(max_pre_id, 5, 11.1, 0.3)
response    = com_test.update(com_test.json)
print(response)
print('UPDATE test complete')

print('TESTING PRESCRIPTIONCOMP COMPLETE')
