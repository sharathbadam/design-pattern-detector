import javalang
import re

def detect_factory(filename):
    # Detection using javalang
    with open(filename, 'r') as f:
        tree = javalang.parse.parse(f.read())
        for class_decl in tree.types:
            if isinstance(class_decl, javalang.tree.ClassDeclaration):
                if 'Factory' in class_decl.name:
                    has_factory_method = False
                    for method_decl in class_decl.methods:
                        if 'create' in method_decl.name:
                            has_factory_method = True
                            break
                    if has_factory_method:
                        return True

    # Detection using regular expressions
    with open(filename, 'r') as f:
        file_contents = f.read()

        # Match patterns for factory classes
        pattern = re.compile(r'''
            public\s+class\s+(\w+)\s*\{
            \s*public\s+\w+\s+create\w+\s*\(\s*\)\s*\{
            ([^}]*new\s+\w+\s*\(\s*\)\s*;[^}]*\})+
            \s*\}
        ''', re.MULTILINE | re.DOTALL | re.VERBOSE)

        if pattern.search(file_contents):
            return True

    return False
