import json
from API.prescription       import Prescription

print('TESTING PRESCRIPTION STARTED')

#print('LIST1 test started!')
com_test    = Prescription()
_list       = json.loads(com_test.list())
print(json.dumps(_list, indent=4))
print('LIST1 test complete!')

print('GET test started!')
max_id      = max([x['prescription_id'] for x in _list])
obj         = com_test.get(max_id)
print(obj)
print('GET test complete!')

print('CREATE test started!')
_id         = max_id + 1
com_test.setJson('TestCreate', _id)
response    = com_test.create(com_test.json)
print(response)
print('CREATE test complete')

print('UPDATE test started!')
com_test.setJson('TestUpdate', _id)
response    = com_test.update(com_test.json)
print(response)
print('UPDATE test complete')

print('TESTING PRESCRIPTION COMPLETE')
